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

includeTargets << grailsScript("Init")

final tempDir = "${basedir}/tmp"
final resourcesDir = "${basedir}/resources"
final descriptorsDir = "${basedir}/descriptors"

target(compileReports: "Compiles jasper report designs.") {
    ant.taskdef(name: "jrc", classname: "net.sf.jasperreports.ant.JRAntCompileTask" )

    delete(dir: "${resourcesDir}/reports")
    mkdir(dir: "${resourcesDir}/reports")
    //error reports are generated here and files saved by the asset upload process
    mkdir(dir: "${resourcesDir}/reports/assets")

    mkdir(dir: tempDir)
    jrc(destdir: "${resourcesDir}/reports", tempdir: tempDir, keepjava: "true", xmlvalidation: "true") {
        src {
            fileset(dir: "${descriptorsDir}/reports", includes: "**/*.jrxml")
        }
    }
    delete(dir: tempDir)
}

setDefaultTarget(compileReports)