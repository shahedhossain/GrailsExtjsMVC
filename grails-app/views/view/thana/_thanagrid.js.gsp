Ext.define('Ext4Example.view.thana.ThanaGrid' ,{
extend: 'Ext.grid.Panel',
alias : 'widget.thanagrid',

title : 'Thana Name',
width: 200,
height:300,

viewConfig: {
stripeRows: true
},

initComponent: function() {

this.store = 'Thanas',

this.tbar = [{

text: 'Add', 
action: 'add'
}, '-', {
text: 'Delete',
action: 'delete'
}],



this.columns = [{
text     : 'ID',
// flex     : 1,
width    :40,
sortable : false,
dataIndex: 'id'
},
{
text     : 'NameEn',
width    : 75,
sortable : true,
//renderer : 'usMoney',
dataIndex: 'nameEn'
},
{
text     : 'NameBn',
width    : 75,
sortable : true,
//renderer : this.change,
dataIndex: 'nameBn'
}];

this.callParent(arguments);
}
});


