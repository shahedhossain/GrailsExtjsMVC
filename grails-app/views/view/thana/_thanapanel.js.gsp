Ext.define('Ext4Example.view.thana.ThanaPanel' ,{
    extend: 'Ext.form.Panel',
    alias : 'widget.thanapanel',
 
    frame: true,
    title: 'Thana Details',
    bodyPadding: 5,
    layout: 'column',
 
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'side'
    },
 
   items: [{
        xtype: 'thanagrid',
        columnWidth: .15
    },{
        xtype: 'thanaform',
        columnWidth: .30
    }]
 
});


