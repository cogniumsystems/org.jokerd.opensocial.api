package org.jokerd.opensocial.api.model.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jokerd.opensocial.api.model.DataObject;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * @author kotelnikov
 */
public class TagCloud extends DataObject {

    public static IJsonValueFactory<TagCloud> FACTORY = new IJsonValueFactory<TagCloud>() {
        @Override
        public TagCloud newValue(Object object) {
            return new TagCloud().setJsonObject(object);
        }
    };

    public TagCloud() {
    }

    public TagCloud(Collection<Tag> tags) {
        this();
        setTags(tags);
    }

    public TagCloud addTag(String tag, int weight) {
        setValue(tag, weight);
        return this;
    }

    public TagCloud addTag(Tag tag, int weight) {
        return addTag(tag.toString(), weight);
    }

    public Set<Tag> getTags() {
        Set<String> tags = getKeys();
        List<Tag> result = new ArrayList<Tag>();
        for (String str : tags) {
            result.add(new Tag(str));
        }
        Collections.sort(result);
        return new LinkedHashSet<Tag>(result);
    }

    public Map<Tag, Integer> getTagsAsMap() {
        Set<String> tags = getKeys();
        Map<Tag, Integer> result = new HashMap<Tag, Integer>();
        for (String tag : tags) {
            int value = getInteger(tag, -1);
            if (value >= 0) {
                result.put(new Tag(tag), value);
            }
        }
        return result;
    }

    public int getWeight(Tag tag) {
        return getInteger(tag.toString(), -1);
    }

    public TagCloud setStringTags(Map<String, Integer> map) {
        Set<Tag> tags = getTags();
        for (Tag tag : tags) {
            removeValue(tag.toString());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            addTag(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public void setTags(Collection<Tag> tags) {
        for (Tag tag : tags) {
            addTag(tag, 1);
        }
    }

    public TagCloud setTags(Map<Tag, Integer> map) {
        Set<Tag> tags = getTags();
        for (Tag tag : tags) {
            removeValue(tag.toString());
        }
        for (Map.Entry<Tag, Integer> entry : map.entrySet()) {
            addTag(entry.getKey(), entry.getValue());
        }
        return this;
    }

}