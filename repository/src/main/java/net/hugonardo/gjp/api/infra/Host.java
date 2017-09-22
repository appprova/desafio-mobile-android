package net.hugonardo.gjp.api.infra;

/**
 * Oferece suporte a hosts diferentes por buildType
 */
public enum Host {
    DEBUG("https://api.github.com/"),
    RELEASE("https://api.github.com/");

    private final String mBaseUrl;

    Host(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public static Host fromBuildType(String buildType) {
        return Host.valueOf(buildType.toUpperCase());
    }
}
