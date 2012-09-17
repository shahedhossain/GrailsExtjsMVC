Ext.define('Ext4Example.model.User', {
    extend: 'Ext.data.Model',
    fields: [
    {
        name:'id', 
        mapping:'id', 
        type:'int'
    },

    {
        name:'name', 
        mapping:'name', 
        type:'string'
    },

    {
        name:'email', 
        mapping:'email', 
        type:'string'
    }
    ],
    validations:[
    {
        type:'lenght', 
        field:'name', 
        min:2
    },

    {
        type:'format', 
        field:'name', 
        matcher:/^[\w\d,.#:\-/ ]{2,45}$/
    },

    {
        type:'format', 
        field:'email', 
        matcher: /^[\p{InBengali}\u0964,.#:\-/ ]{0,60}$/
    }
    ]
});
 
