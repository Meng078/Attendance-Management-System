<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div>
        <BasicTable @register="register" :rowSelection="rowSelection">
            <template #tableTitle>
                <a-button @click="onExportXls">导出</a-button>
                <a-button @click="onImportXls">导入</a-button>
                <a-button>setProps</a-button>
            </template>
        </BasicTable>
    </div>
</template>

<script setup lang="ts">
import { ActionItem, BasicColumn, BasicTable, TableAction } from '/@/components/Table';
import { useListPage } from '/@/hooks/system/useListPage';
import { defHttp } from '/@/utils/http/axios';
import { columns, schemas } from './data';
const api = {
    list: '/sys/user/listAll',
    deleteUser: '/sys/user/delete',
    import: '/sys/user/importExcel',
    export: '/sys/user/exportXls'
}
const apiList = (params) => {
    return defHttp.get({ url: api.list, params });
}
const { tableContext, onExportXls, onImportXls } = useListPage({
    tableProps: {
        api: apiList,
        columns: columns,
        formConfig: {
            schemas: schemas
        },
        tableSetting: {
            fullScreen: true
        }
    },
    importConfig: {
        url: api.import
    },
    exportConfig: {
        name: '用户',
        url: api.export
    }
})
//解构表格
const [register, { setProps, reload },{ rowSelection }] = tableContext
</script>

<style lang="less" scoped></style>