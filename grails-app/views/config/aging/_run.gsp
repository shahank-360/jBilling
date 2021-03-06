%{--
  JBILLING CONFIDENTIAL
  _____________________

  [2003] - [2012] Enterprise jBilling Software Ltd.
  All Rights Reserved.

  NOTICE:  All information contained herein is, and remains
  the property of Enterprise jBilling Software.
  The intellectual and technical concepts contained
  herein are proprietary to Enterprise jBilling Software
  and are protected by trade secret or copyright law.
  Dissemination of this information or reproduction of this material
  is strictly forbidden.
  --}%

<%--
  form for date selection and triggering Collections process

  @author Igor Poteryaev
  @since  17-Mar-2014
--%>

<div id="collectionsRun" class="form-hold">
    <fieldset>
        <div class="form-columns single">
            <div class="column">
                 <g:applyLayout name="form/date">
                     <content tag="label"><g:message code="config.collections.run.date"/></content>
                     <content tag="label.for">collectionsRunDate</content>
                     <g:textField class="field" name="collectionsRunDate"
                            value="${formatDate(date: new Date(), formatName: 'datepicker.format')}"
                            onblur="validateDate(this)"/>
                 </g:applyLayout>
            </div>
        </div>
    </fieldset>
    <div class="btn-row">
        <g:submitButton name="run" class="submit confirm" style="float:none" value="${message(code: 'button.run.collections')}" />
    </div>
    <script type="text/javascript">
        setTimeout(
            function() {
                $("#collectionsRunDate").datepicker("option", "minDate", new Date());
            },
            $("#collectionsRunDate").is(":visible") ? 10 : 510
        );
    </script>
    <script type="text/javascript">
        $(function(){
            $('#confirm-dialog').dialog({
                autoOpen: false,
                width: 480,
                modal: true,
                resizable: false,
                title: "${message(code: 'popup.confirm.title')}",
                open: function( event, ui ) {
                    $("#btnCancel").focus();
                }
            });

            $('form input.confirm').click(function (e) {
                e.preventDefault();
                var form = $(e.target).closest("form");
                var dlg  = $('#confirm-dialog');
                var msg  = "${message(code: 'config.collections.run.confirm')}";
                var icon = "<span class='ui-icon ui-icon-alert' style='float:left; margin:0 7px 0 0;'></span>";
                dlg.html("<p>"+ icon + msg +"</p>");
                dlg.dialog("option", "buttons", [
                    {
                        text:  "${message(code: 'button.run.collections')}",
                        click: function() {form.submit();},
                        'class': 'ui-priority-secondary'
                    },
                    {
                        id:    "btnCancel",
                        text:  "${message(code: 'button.cancel')}",
                        click: function() {$(this).dialog("close");},
                    }
                ]);
                dlg.dialog('open');
            });
        });
    </script>
    <div id="confirm-dialog"></div>
</div>
