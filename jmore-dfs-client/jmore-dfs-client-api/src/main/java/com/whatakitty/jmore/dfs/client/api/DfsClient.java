package com.whatakitty.jmore.dfs.client.api;

import com.whatakitty.jmore.dfs.client.api.domain.Object;
import com.whatakitty.jmore.dfs.client.api.domain.ObjectKey;
import com.whatakitty.jmore.dfs.client.api.visitor.Visitor;
import java.util.List;
import java.util.concurrent.Future;

/**
 * dfs client
 *
 * @author WhatAKitty
 * @date 2020/07/05
 * @since 1.0.0
 **/
public interface DfsClient<T extends ObjectKey<?>> {

    /**
     * register a collection of listeners
     *
     * @param listeners listeners list
     */
    void registerListeners(List<DfsListener> listeners);

    /**
     * init dfs client
     */
    void init();

    /**
     * create directories recursively
     *
     * @param directoryUrl directory url
     * @return the result
     */
    Future<Boolean> createDirectories(String directoryUrl);

    /**
     * upload object put dfs
     *
     * @param object the object need to upload
     * @param mkdir  to create parent directories while not exist
     */
    Future<Boolean> putObject(Object<T> object, boolean mkdir);

    /**
     * download object from dfs
     *
     * @param objectKey the object key
     * @return the object will be downloaded
     */
    Future<Object<T>> getObject(T objectKey);

    /**
     * visit all objects
     *
     * @param visitor the visitor to visit the objects in dfs
     */
    void visit(Visitor visitor);

    /**
     * destroy this client
     */
    void destroy();

}
