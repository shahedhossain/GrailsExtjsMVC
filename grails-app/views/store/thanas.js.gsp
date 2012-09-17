Ext.define('Ext4Example.store.Thanas', {
    extend: 'Ext.data.Store',
    model: 'Ext4Example.model.Thana',
    idProperty:'id',
    autoLoad:true,
    proxy: {
      type:'ajax',
      url:'store',
      reader:{
        type:'json',
        root:'data',
        totalProperty: 'num'
      }
    }
});


