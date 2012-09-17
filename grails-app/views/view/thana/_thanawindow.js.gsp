Ext.define('Ext4Example.view.thana.ThanaWindow' ,{
    extend: ' Ext.Window',
    alias : 'widget.thanawindow',
 
    margin: '0 0 0 10',
 
    title: 'Grid example',
    width:400,
    height:360,
    layout:'form'
    defaults: {
        width: 240,
        labelWidth: 90
    },
 
    defaultType: 'textfield',
 
    items: [{
        fieldLabel: 'ID',
        name: 'id'
    },{
        fieldLabel: 'NameEn',
        name: 'nameEn'
    },{
        fieldLabel: 'NameBn',
        name: 'nameBn'
    }]
});


