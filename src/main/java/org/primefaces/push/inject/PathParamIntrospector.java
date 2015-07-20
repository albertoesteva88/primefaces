/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.push.inject;

import org.atmosphere.config.service.PathParam;
import org.atmosphere.inject.annotation.RequestScoped;

import java.lang.reflect.Field;

/**
 * {@link PathParam} injection support.
 *
 * @author Jeanfrancois Arcand
 */
@RequestScoped({PathParam.class})
public class PathParamIntrospector extends org.atmosphere.inject.PathParamIntrospector {

    @Override
    public void introspectField(Field f) {
        if (f.isAnnotationPresent(PathParam.class)) {
            String name = f.getAnnotation(PathParam.class).value();

            if (name.isEmpty()) {
                name = f.getName();
            }
            pathLocal.set(name);
        }
    }

}
