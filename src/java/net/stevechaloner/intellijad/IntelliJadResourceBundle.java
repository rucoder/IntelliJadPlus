/*
 * Copyright 2007 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package net.stevechaloner.intellijad;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

/**
 * Resource bundle used for localisation of messages.
 */
public class IntelliJadResourceBundle {

    /**
     * The bundle.
     */
    private static Reference<ResourceBundle> BUNDLE;

    /**
     * The basename of the bundle.
     */
    @NonNls
    private static final String BUNDLE_NAME = "net.stevechaloner.intellijad.messages-i18n";


    /**
     * Should not be instantiated.
     */
    private IntelliJadResourceBundle() {
    }

    /**
     * Gets the message for the given key with any parameters substituted in place.
     *
     * @param key    the key of the message
     * @param params parameters for the message
     * @return the formatted message
     */
    public static String message(@PropertyKey(resourceBundle = BUNDLE_NAME)String key,
                                 Object... params) {
        return CommonBundle.message(getBundle(),
                key,
                params);
    }

    /**
     * Loads the bundle.
     *
     * @return the bundle
     */
    private static ResourceBundle getBundle() {
        ResourceBundle bundle = null;
        if (BUNDLE != null) {
            bundle = BUNDLE.get();
        }
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE_NAME);
            BUNDLE = new SoftReference<ResourceBundle>(bundle);
        }
        return bundle;
    }
}
