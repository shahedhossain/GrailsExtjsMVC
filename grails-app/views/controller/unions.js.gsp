Ext.define('Ext4Example.controller.Unions', {
    extend: 'Ext.app.Controller',

    models: ['Union'],

    views: ['union.UnionForm','union.UnionPanel','union.UnionGrid'],

    refs: [{
        ref: 'unionForm',
        selector: 'form'
    }]
});



