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

package com.sapienter.jbilling.server.mediation.sourceUploader;

import org.springframework.integration.file.remote.session.SessionFactory;


public interface RemoteFileUploader<T extends SessionFactory> {
    boolean copyToRemoteFileSystem();
    boolean copyToRemoteFileSystemFrom(T sessionFactory);
    boolean copyToRemoteFileSystemFrom(String username, String password, String server, int port);
}
