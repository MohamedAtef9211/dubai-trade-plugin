package ae.dubaitrade.mobile.dubaitradebackendplugin.config;

import org.jsonschema2pojo.AnnotationStyle;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.InclusionLevel;
import org.jsonschema2pojo.SourceType;

public class DefaultGenerationConfigImpl extends DefaultGenerationConfig {

    @Override
    public boolean isGenerateBuilders() {
        return false;
    }

    @Override
    public SourceType getSourceType() {
        return SourceType.JSON;
    }

    @Override
    public boolean isIncludeToString() {
        return false;
    }

    @Override
    public boolean isIncludeAdditionalProperties() {
        return false;
    }

    @Override
    public AnnotationStyle getAnnotationStyle() {
        return AnnotationStyle.NONE;
    }

    @Override
    public boolean isIncludeHashcodeAndEquals() {
        return false;
    }

    @Override
    public boolean isIncludeConstructors() {
        return false;
    }

    @Override
    public boolean isIncludeAllPropertiesConstructor() {
        return false;
    }

    @Override
    public boolean isIncludeGetters() {
        return false;
    }

    @Override
    public boolean isIncludeSetters() {
        return false;
    }

    @Override
    public boolean isIncludeDynamicGetters() {
        return false;
    }

    @Override
    public boolean isIncludeDynamicSetters() {
        return false;
    }

    @Override
    public boolean isIncludeConstructorPropertiesAnnotation() {
        return false;
    }

    @Override
    public boolean isIncludeGeneratedAnnotation() {
        return false;
    }
}
