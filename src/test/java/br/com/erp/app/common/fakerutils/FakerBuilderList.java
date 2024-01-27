package br.com.erp.app.common.fakerutils;

import java.util.ArrayList;
import java.util.List;

public abstract class FakerBuilderList<T> {

    public abstract T getFake();

    public List<T> getFake(int size) {
        final List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(getFake());
        }
        return list;
    }
}