package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class DependencyCycleException extends DependencyException {
    public DependencyCycleException(List<C3634d<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
    }
}
