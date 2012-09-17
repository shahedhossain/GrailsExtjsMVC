Ext.define('Ext4Example.view.union.UnionPanel' ,{
    extend: 'Ext.form.Panel',
    alias : 'widget.unionpanel',
 
    frame: true,
    title: 'Union Details',
    bodyPadding: 5,
    layout: 'column',    // Specifies that the items will now be arranged in columns
 
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'side'
    },
 
   items: [{
        xtype: 'uniongrid',
        columnWidth: .15
    },{
        xtype: 'unionform',
        columnWidth: .30
    }]
 
});


