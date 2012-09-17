Ext.define('Ext4Example.view.union.UnionForm' ,{
    extend: 'Ext.window.Window',
    alias : 'widget.unionform',

 
    title:'Name Of Union',
    //layout: 'fit',
    autoShow: 'true',
 
    initComponent: function() {
        this.items = [
        {
            xtype: 'form',
            items: [
            {
                xtype: 'textfield',
                name : 'id',
                fieldLabel: 'ID'
            },
            {
                xtype: 'textfield',
                name : 'nameEn',
                allowBlank: false,
                fieldLabel: 'NameEn'
            },
            {
                xtype: 'textfield',
                name : 'nameBn',
                fieldLabel: 'NameBn'
            }
            ]
        }
        ];

        this.buttons = [
        {
            text: 'Save',
            action: 'save'
        },
        {
            text: 'Cancel',
            scope: this,
            handler: this.close
        }
        ];

        this.callParent(arguments);
    }
});


