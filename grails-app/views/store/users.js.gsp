Ext.define('Ext4Example.store.Users', {
    extend: 'Ext.data.Store',
    model: 'Ext4Example.model.User',
    autoLoad: true,
    autoSync: true,
    idProperty:'id',
    remoteSort: true,
    pageSize: 10,
    proxy: {
        type: 'ajax',
        limitParam: 'limit',
        startParam: 'start',
        api: {
            create: 'add',
            read: 'list',
            update: 'update',
            destroy: 'delete'
        },
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'num',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: false
        },
        simpleSortMode: true
    },
    sorters: [{property: 'id', direction: 'asc'}]
});