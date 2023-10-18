package br.com.somar.app.common.fakerutils;

import net.datafaker.Faker;

import java.util.*;

public abstract class FakerBuilderSet<T> {

    public abstract T getFake();

    public Set<T> getFake(int size) {
        final Set<T> list = new HashSet<>();
        for (int i = 0; i < size; i++) {
            list.add(getFake());
        }
        return list;
    }
}