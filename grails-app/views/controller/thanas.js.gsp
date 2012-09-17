Ext.define('Ext4Example.controller.Thanas', {
    extend: 'Ext.app.Controller',

    models: ['Thana'],

    stores: ['Thanas'],

    views: ['thana.ThanaForm','thana.ThanaPanel','thana.ThanaGrid'],
    

    refs: [{
        ref: 'thanaForm',
        selector: 'form'
    }, {
        ref: 'thanaGrid',
        selector: 'grid'
    }

    ],


    init: function() {

        this.control({
            'thanagrid > toolbar > button[action=add]': {
                click: this.onCreateUser
            },
            'thanagrid > toolbar > button[action=delete]': {
                click: this.onCreateUser1
            },
            'unionform button[action=save]': {
                click: this.doCreateUser
            }
        });
    },
    
    onCreateUser: function () {
        var view = Ext.widget('thanaform');
        view.show();
    },
    onCreateUser1: function (user) {
        Ext.Msg.confirm('Remove User', 'Are you sure want to delete?', function (button) {
            if (button == 'yes') {
                this.getUsersStore().remove(user);
            }
        }, this);
    },

    doCreateUser: function (button) {
        var win = button.up('window'),
        form = win.down('form'),
        values = form.getValues(),
        store = this.getUsersStore();
        if (form.getForm().isValid()) {
            store.add(values);
            win.close();
        }
    }

});






