Ext.define('Ext4Example.model.User', {
    extend: 'Ext.data.Model',
    fields: [
      {name:'id', mapping:'id', type:'int'},
      {name:'name', mapping:'name',type:'string'},
      {name:'email',mapping:'email',type:'string'}
    ]
});
 