/*
 * Copyright 2018 Yan Zhenjie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yanzhenjie.andserver.processor;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.lang.model.SourceVersion;

/**
 * Created by YanZhenjie on 2018/6/8.
 */
public abstract class BaseProcessor extends AbstractProcessor {

    @Override
    public final SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public final Set<String> getSupportedAnnotationTypes() {
        Set<Class<? extends Annotation>> classSet = new HashSet<>();
        addAnnotation(classSet);

        Set<String> nameSet = new HashSet<>();
        for (Class<? extends Annotation> clazz : classSet) {
            nameSet.add(clazz.getCanonicalName());
        }
        return nameSet;
    }

    protected abstract void addAnnotation(Set<Class<? extends Annotation>> classSet);
}