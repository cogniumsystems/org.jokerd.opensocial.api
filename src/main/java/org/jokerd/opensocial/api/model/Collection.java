/**
 * 
 */
package org.jokerd.opensocial.api.model;

import java.util.List;

import org.ubimix.commons.json.JsonObject;

/**
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/1.1/Core-Data.xml#Collection

public class Collection<T extends JsonObject> extends JsonObject {

    public static <T extends JsonObject> IJsonValueFactory<Collection<T>> getCollectionFactory(
        final IJsonValueFactory<T> factory) {
        return new IJsonValueFactory<Collection<T>>() {
            @Override
            public Collection<T> newValue(Object object) {
                Collection<T> collection = new Collection<T>(factory);
                collection.setJsonObject(object);
                return collection;
            }
        };
    }

    private final IJsonValueFactory<T> fFactory;

    /**
     * 
     */
    public Collection(IJsonValueFactory<T> factory) {
        fFactory = factory;
    }

    /**
     * Array<Object> An array of objects, one for each item matching the
     * request. For consistency of parsing, if the request could possibly return
     * multiple items (as is normally the case), this value MUST always be an
     * array of results, even if there happens to be 0 or 1 matching results.
     * (i.e. "entry": [ { /- first item -/ }, { /- seond item -/ } ]).
     * 
     * @param <T>
     * @param factory
     */
    public List<T> getEntries() {
        return getList("entry", fFactory);
    }

    public IJsonValueFactory<T> getFactory() {
        return fFactory;
    }

    /**
     * The number of results returned per page in this response. In general,
     * this will be equal to the count Query Parameter, but MAY be less if the
     * Service Provider is unwilling to return as many results per page as
     * requested, or if there are less than the requested number of results left
     * to return when starting at the current startIndex. This field MUST be
     * present if and only if a value for count is specified in the request.
     */
    public int getItemsPerPage() {
        return getInteger("itemsPerPage", 0);
    }

    /**
     * The index of the first result returned in this response, relative to the
     * starting index of all results that would be returned if no startIndex had
     * been requested. In general, this will be equal to the value requested by
     * the startIndex, or 0 if no specific startIndex was requested.
     */
    public int getStartIndex() {
        return getInteger("startIndex", 0);
    }

    /**
     * The total number of contacts that would be returned if there were no
     * startIndex or count specified. This value tells the Consumer how many
     * total results to expect, regardless of the current pagination being used,
     * but taking into account the current filtering options in the request.
     */
    public int getTotalResults() {
        return getInteger("totalResults", 0);
    }

    /**
     * Boolean indicating if the result honors filter params in the request. The
     * default value is 'true' if the field does not exist.
     */
    public boolean isFiltered() {
        return getBoolean("filtered", true);
    }

    /**
     * Boolean Indicating if the items are sorted. The default value is 'true'
     * if the field does not exist.
     */
    public boolean isSorted() {
        return getBoolean("sorted", true);
    }

    /**
     * Indicating if the result honors the updatedSince param in the request.
     * The default value is 'true' if the field does not exist.
     */
    public boolean isUpdatedSince() {
        return getBoolean("updatedSince", true);
    }

    /**
     * Array<Object> An array of objects, one for each item matching the
     * request. For consistency of parsing, if the request could possibly return
     * multiple items (as is normally the case), this value MUST always be an
     * array of results, even if there happens to be 0 or 1 matching results.
     * (i.e. "entry": [ { /- first item -/ }, { /- second item -/ } ]).
     */
    public void setEntries(List<? extends T> entries) {
        setValue("entry", entries);
    }

    /**
     * Boolean indicating if the result honors filter params in the request. The
     * default value is 'true' if the field does not exist.
     */
    public void setFiltered(boolean value) {
        setValue("filtered", value);
    }

    /**
     * The number of results returned per page in this response. In general,
     * this will be equal to the count Query Parameter, but MAY be less if the
     * Service Provider is unwilling to return as many results per page as
     * requested, or if there are less than the requested number of results left
     * to return when starting at the current startIndex. This field MUST be
     * present if and only if a value for count is specified in the request.
     */
    public void setItemsPerPage(int value) {
        setValue("itemsPerPage", value);
    }

    /**
     * Boolean Indicating if the items are sorted. The default value is 'true'
     * if the field does not exist.
     */
    public void setSorted(boolean value) {
        setValue("sorted", value);
    }

    /**
     * The index of the first result returned in this response, relative to the
     * starting index of all results that would be returned if no startIndex had
     * been requested. In general, this will be equal to the value requested by
     * the startIndex, or 0 if no specific startIndex was requested.
     */
    public void setStartIndex(int startIndex) {
        setValue("startIndex", startIndex);
    }

    /**
     * The total number of contacts that would be returned if there were no
     * startIndex or count specified. This value tells the Consumer how many
     * total results to expect, regardless of the current pagination being used,
     * but taking into account the current filtering options in the request.
     */
    public void setTotalResults(int value) {
        setValue("totalResults", value);
    }

    /**
     * Indicating if the result honors the updatedSince param in the request.
     * The default value is 'true' if the field does not exist.
     */
    public void setUpdatedSince(boolean value) {
        setValue("updatedSince", value);
    }

}
