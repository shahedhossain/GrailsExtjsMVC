Ext.define('Ext4Example.view.union.UnionGrid' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.uniongrid',
 
    title : 'Union Name',

 
    viewConfig: {
        stripeRows: true
    },
 
    initComponent: function() {
 
        //this.store = 'Districts';
 
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


