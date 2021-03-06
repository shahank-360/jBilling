package com.sapienter.jbilling.test.framework.helpers;

import com.sapienter.jbilling.server.metafields.*;
import com.sapienter.jbilling.server.metafields.db.MetaField;
import com.sapienter.jbilling.server.metafields.validation.ValidationRuleWS;

/**
 * Here we place various helper methods
 * used in tests.
 * This class is not designed to be instantiated
 * or sub-classed.
 *
 * @author Vojislav Stanojevikj
 * @since 10-JUN-2016.
 */
public final class ApiBuilderHelper {

    private ApiBuilderHelper(){}


    /**
     * Creates simple {@link MetaFieldValueWS} object
     * with <code>fieldName</code> and <code>value</code>.
     *
     * @param fieldName the name of the meta-field.
     * @param value the value of the meta-field.
     * @return {@link MetaFieldValueWS} object representation.
     */
    public static MetaFieldValueWS getMetaFieldValueWS(String fieldName, Object value) {
        MetaFieldValueWS metaField11 = new MetaFieldValueWS();
        metaField11.setFieldName(fieldName);
        metaField11.setValue(value);
        return metaField11;
    }

    /**
     * Creates a {@link MetaFieldWS} object
     * with <code>fieldName</code> of <code>type</code>,
     * for <code>entityType</code> and <code>entityId</code>.
     *
     * @param fieldName the name of the field.
     * @param type the type of the field.
     * @param entityType the entity type of the field.
     * @param entityId the owning entity.
     * @return {@link MetaFieldWS} object representation.
     * @see DataType
     * @see EntityType
     */
    public static MetaFieldWS getMetaFieldWS(String fieldName, DataType type,
                                             EntityType entityType, Integer entityId) {
        MetaFieldWS metaField11 = new MetaFieldWS();
        metaField11.setName(fieldName);
        metaField11.setDataType(type);
        metaField11.setEntityId(entityId);
        metaField11.setEntityType(entityType);
        return metaField11;
    }

    public static MetaFieldWS getMetaFieldWithValidationRule(String fieldName, DataType type,
                                             EntityType entityType, Integer entityId,
                                             MetaFieldType metaFieldType, ValidationRuleWS validationRule) {
        MetaFieldWS metaField = new MetaFieldWS();
        metaField.setName(fieldName);
        metaField.setDataType(type);
        metaField.setEntityId(entityId);
        metaField.setEntityType(entityType);
        metaField.setFieldUsage(metaFieldType);
        metaField.setValidationRule(validationRule);
        return metaField;
    }


}
