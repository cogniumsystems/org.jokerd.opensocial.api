/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.JsonObject;
import org.ubimix.commons.json.ext.FormattedDate;

/**
 * @author kotelnikov
 */
public class DataObject extends JsonObject {

    /**
     * 
     */
    public DataObject() {
    }

    /**
     * @param object
     */
    public DataObject(Object object) {
        super(object);
    }

    protected FormattedDate getDate(String field) {
        return getValue(field, FormattedDate.FACTORY);
    }

    public <E> PluralFields<E> getPluralFields(
        String key,
        IJsonValueFactory<E> factory) {
        return addValues(key, new PluralFieldsImpl<E>(), factory);
    }

    public <E> PluralFields<E> newPluralFields() {
        return new PluralFieldsImpl<E>();
    }

    protected void setDate(String field, FormattedDate date) {
        setValue(field, date);
    }

    @Override
    public JsonObject setValue(String name, Object value) {
        if (value == null) {
            return super.removeValue(name);
        } else {
            return super.setValue(name, value);
        }
    }

}
