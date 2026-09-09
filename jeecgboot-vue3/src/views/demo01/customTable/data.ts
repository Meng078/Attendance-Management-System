import { render } from "/@/utils/common/renderUtils";
import { BasicColumn, FormSchema } from "/@/components/Table";
import { BellFilled } from "@ant-design/icons-vue";
export const columns: BasicColumn[] = [
    {
        title: '用户账号',
        dataIndex: 'username',
        align: 'left',
        resizable: true
    },
    {
        title: '用户姓名',
        dataIndex: 'realname'
    }, {
        title: '手机号',
        dataIndex: 'phone',
        auth: 'screenRecord:basicTable:phone'
    },
    {
        title: '邮箱',
        dataIndex: 'email'
    },
    {
        title: '性别',
        dataIndex: 'sex',
        customRender: ({ text }) => {
            return render.renderDict(text, 'sex');
        }
    },
    {
        title: '部门',
        dataIndex: 'orgCodeTxt'
    }
]
export const schemas: FormSchema[] = [
    {
        field: 'username',
        label: '用户账号',
        component: 'JInput'
    }, 
    {
        field: 'realname',
        label: '用户姓名',
        component: 'JInput'
    }
]