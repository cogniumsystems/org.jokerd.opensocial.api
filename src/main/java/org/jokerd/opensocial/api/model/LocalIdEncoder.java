/* ************************************************************************** *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 * 
 * This file is licensed to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * ************************************************************************** */
package org.jokerd.opensocial.api.model;

/**
 * @author kotelnikov
 */
public class LocalIdEncoder {

    private final static char ESCAPE_SYMBOL = '_';

    private static LocalIdEncoder fInstance;

    /**
     * @return the instance
     */
    public static LocalIdEncoder getInstance() {
        if (fInstance == null) {
            fInstance = new LocalIdEncoder();
        }
        return fInstance;
    }

    /**
     * @param instance the instance to set
     */
    public static void setInstance(LocalIdEncoder instance) {
        fInstance = instance;
    }

    protected LocalIdEncoder() {
    }

    private void appendEscaped(StringBuffer buf, int ch) {
        String str = Integer.toHexString(ch).toUpperCase();
        buf.append(ESCAPE_SYMBOL);
        buf.append(str);
    }

    /**
     * @param key the value to encode
     * @return the URL-encoded string corresponding to the given value
     */
    public String decode(String value) {
        StringBuffer buf = new StringBuffer();
        if (value != null) {
            char[] array = value.toCharArray();
            int ch = 0;
            int chPos = 0;
            int chLen = 1;
            for (int i = 0; i < array.length; i++) {
                char currentByte = array[i];
                if (currentByte == ESCAPE_SYMBOL) {
                    if (i < array.length - 2) {
                        String s = new String(array, i + 1, 2);
                        int code = (char) Integer.parseInt(s, 16);
                        i += 2;
                        if (chPos == 0) {
                            if (code >= 0x00 && code <= 0x7F) {
                                chLen = 1;
                                code &= (0xFF >>> 1);
                            } else if (code >= 0xC2 && code <= 0xDF) {
                                chLen = 2;
                                code &= (0xFF >>> 3);
                            } else if (code >= 0xE0 && code <= 0xEF) {
                                chLen = 3;
                                code &= (0xFF >>> 4);
                            } else if (code >= 0xF0 && code <= 0xF4) {
                                chLen = 4;
                                code &= (0xFF >>> 5);
                            }
                        } else {
                            code &= (0xFF >>> 2);
                        }
                        if (chPos == chLen - 1) {
                            ch |= code;
                        } else if (chPos == chLen - 2) {
                            ch |= code << 6;
                        } else if (chPos == chLen - 3) {
                            ch |= code << 12;
                        }
                    }
                } else {
                    ch = currentByte;
                    chLen = 1;
                }
                chPos++;
                if (chPos >= chLen) {
                    buf.append((char) ch);
                    ch = 0;
                    chPos = 0;
                }
            }
        }
        return buf.toString();
    }

    /**
     * @param encode
     * @param escape
     * @param key the value to encode
     * @return the URL-encoded string corresponding to the given value
     */
    public String encode(String value) {
        StringBuffer buf = new StringBuffer();
        if (value != null) {
            char[] array = value.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char ch = array[i];
                if (ch < 128) {
                    if ((ch >= 'A' && ch <= 'Z')
                        || (ch >= 'a' && ch <= 'z')
                        || (i > 0 && ch >= '0' && ch <= '9')
                        || ch == '.'
                        || ch == '-') {
                        buf.append(ch);
                    } else {
                        appendEscaped(buf, ch);
                    }
                } else if ((ch > 127) && (ch < 2048)) {
                    appendEscaped(buf, (ch >>> 6) | 192);
                    appendEscaped(buf, (ch & 63) | 128);
                } else {
                    appendEscaped(buf, (ch >>> 12) | 224);
                    appendEscaped(buf, ((ch >>> 6) & 63) | 128);
                    appendEscaped(buf, (ch & 63) | 128);
                }
            }
        }
        return buf.toString();
    }

}
