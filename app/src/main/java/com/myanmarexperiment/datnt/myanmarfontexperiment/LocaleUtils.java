package com.myanmarexperiment.datnt.myanmarfontexperiment;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;

import java.util.Locale;

/**
 * Created by thanhdat.nguyen on 4/11/17.
 */

public class LocaleUtils {
    /**
     * Please refer to: http://stackoverflow.com/questions/40221711/android-context-getresources-updateconfiguration-deprecated/40704077#40704077
     *
     * @param context the context
     * @return Context
     */
    @SuppressWarnings("deprecation")
    public static Context wrapContext(@NonNull Context context) {
        final Resources resources = context.getResources();
        final Configuration configuration = resources.getConfiguration();

        Locale locale = getCompatSystemLocale(configuration);

        // Convert to my-rMM for unicode and zg-rMM for Zawgyi
        locale = buildCompatLocale(locale, "my", "mm");

        setCompatSystemLocale(configuration, locale);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context = context.createConfigurationContext(configuration);
        } else {
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }

        return new ContextWrapper(context);
    }

    private static boolean isLocaleRequireConversion(@NonNull final Locale locale) {
        final boolean myanmarCountry = "mm".equals(locale.getCountry()) || "zg".equals(locale.getCountry());
        final boolean myanmarLanguage = "my".equals(locale.getLanguage()) || "zg".equals(locale.getLanguage());
        return myanmarCountry || myanmarLanguage;
    }

    @SuppressWarnings("deprecation")
    private static Locale buildCompatLocale(@NonNull final Locale locale, final String language, final String region) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Locale.Builder builder = new Locale.Builder();
            builder.setLocale(locale);
            builder.setLanguage(language);
            builder.setRegion(region);
            return builder.build();
        }

        return new Locale(language, region, locale.getVariant());
    }

    @SuppressWarnings("deprecation")
    private static Locale getCompatSystemLocale(@NonNull final Configuration configuration) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return configuration.getLocales().get(0);
        }

        return configuration.locale;
    }

    @SuppressWarnings("deprecation")
    private static void setCompatSystemLocale(@NonNull final Configuration configuration, final Locale locale) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale);
        }

        configuration.locale = locale;
    }
}
