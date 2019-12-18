package com.jllalt.mystockapp.data;

public interface ICallback<T> {

    void success(T t);

    void failure(Throwable error);
}
