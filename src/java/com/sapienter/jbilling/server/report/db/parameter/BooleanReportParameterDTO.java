/*
 * JBILLING CONFIDENTIAL
 * _____________________
 *
 * [2003] - [2012] Enterprise jBilling Software Ltd.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Enterprise jBilling Software.
 * The intellectual and technical concepts contained
 * herein are proprietary to Enterprise jBilling Software
 * and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden.
 */

package com.sapienter.jbilling.server.report.db.parameter;

import com.sapienter.jbilling.server.report.db.ReportParameterDTO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * BooleanReportParameterDTO
 *
 * @author Brian Cowdery
 * @since 07/03/11
 */
@Entity
@DiscriminatorValue("boolean")
public class BooleanReportParameterDTO extends ReportParameterDTO<Boolean> {

    private Boolean value;

    @Transient
    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
