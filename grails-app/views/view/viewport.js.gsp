Ext.define('Ext4Example.view.Viewport', {
    extend: 'Ext.Viewport',
    layout: 'fit',
 
    requires: [
        'Ext4Example.view.user.Add',
        'Ext4Example.view.user.Edit',
         'Ext4Example.view.user.List',
    ],
 
    initComponent: function() {
        var me = this;
 
        Ext.apply(me, {
            items: [
                {
                    xtype: 'userlist',
                }
            ]
        });
 
        me.callParent(arguments);
    }
});