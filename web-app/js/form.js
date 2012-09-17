Ext.require([
    'Ext.form.*',
    'Ext.util.*',
    'Ext.tip.QuickTipManager'
]);

Ext.onReady(function() {
    var form = new Ext.FormPanel;
    form.render(document.body);

    var ajax = Ext.Ajax.request({
        url: 'comp',
        method: 'get',
        timeout: 60000,
        success: function(response, request){
            var resText = response.responseText;
            var resData = Ext.decode(resText).data;
            form.add(resData);
            form.doLayout();
        },
        failure: function(results, request){
            Ext.Msg.alert("Error","Unable to render form!");
        }
    });
});
