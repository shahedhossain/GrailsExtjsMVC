Ext.require([
    'Ext.form.*',
    'Ext.tip.*'
]);
Ext.ns('Rdp.demo');
Rdp.demo.xform = {
    
    init: function(){
        Ext.QuickTips.init();
        
        var dist = Ext.create('Ext.form.Panel',{
            url: 'save',
            title: 'District',
            frame: true,
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Name En',
                name: 'nameEn'
            },{
                xtype: 'textfield',
                fieldLabel: 'Name Bn',
                name: 'nameBn'
            }],
            buttons: [{
                id:'save',
                name:'save',
                text:'Save',                
                handler: function() {
                    Rdp.demo.xform.rsave(dist);
                }
            },{
                id: 'reset',
                name:'rest',
                text: 'Reset',
                handler: function(){
                    Rdp.demo.xform.reset(dist);
                }
            }]
        });

        
        var win=new Ext.Window({
            title: 'Grid example',
            bodyStyle:'padding: 10px',
            width:400,
            height:360,
            items:[dist],
            layout:'fit'
        });
        win.show();   
    },
    
    rsave: function(dist){
       dist.getForm().submit({
            success: function(form, action) {
                Ext.Msg.alert('Success', 'Login Successful!', function(btn, text) {
                    if (btn == 'ok') {
                        //window.location = homeUrl;
                    }
                });
            },
            failure: function(form, action) {
                Ext.Msg.alert('Warning', action.result.error);
            }
        });     
    },    
    reset: function(dist) {
        dist.getForm().reset();
    }
    
    
}

Ext.onReady(Rdp.demo.xform.init, Rdp.demo.xform);