Ext.define('Ext4Example.view.thana.ThanaForm' ,{
    extend: 'Ext.window.Window',
    alias : 'widget.thanaform',

 
    title:'Name Of Thana',
    width: 350,
    heigth:350,
    initComponent: function() {
        this.items = [
        {
            xtype: 'form',
             bodyStyle: {
                    background: 'cyan'
                },
            items: [
            {
                xtype: 'textfield',
                name : 'id',
                width: 335,
                fieldLabel: 'ID'
            },
            {
                xtype: 'textfield',
                name : 'nameEn',
                width: 335,
                allowBlank: false,
                fieldLabel: 'NameEn'
            },
            {
                xtype: 'textfield',
                name : 'nameBn',
                width: 335,
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


