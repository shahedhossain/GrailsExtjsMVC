Ext.define('Ext4Example.controller.Districts', {
    extend: 'Ext.app.Controller',
 
    stores: ['Districts'],
 
    models: ['District'],
 
    views: ['district.DistrictGrid','district.DistrictForm','district.DistrictPanel'],
 
    refs: [{
        ref: 'districtForm',
        selector: 'form'
    }],
 
    init: function() {
 
        this.control({
            'districtgrid': {
                selectionchange: this.gridSelectionChange,
                viewready: this.onViewReady
            }
        });
    },
 
    gridSelectionChange: function(model, records) {
 
        if (records[0]) {
             this.getDistrictForm().getForm().loadRecord(records[0]);
        }
    },
 
    onViewReady: function(grid) {
        grid.getSelectionModel().select(0);
    }
});
