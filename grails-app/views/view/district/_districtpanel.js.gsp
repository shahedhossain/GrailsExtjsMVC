Ext.define('Ext4Example.view.district.DistrictPanel' ,{
    extend: 'Ext.form.Panel',
    alias : 'widget.districtpanel',
 
    frame: true,
    title: 'Company Data',
    bodyPadding: 5,
    layout: 'column',    // Specifies that the items will now be arranged in columns
 
    fieldDefaults: {
        labelAlign: 'left',
        msgTarget: 'side'
    },
 
    items: [{
        xtype: 'districtgrid',
        columnWidth: .70
    },{
        xtype: 'districtform',
        columnWidth: .30
    }]
 
});