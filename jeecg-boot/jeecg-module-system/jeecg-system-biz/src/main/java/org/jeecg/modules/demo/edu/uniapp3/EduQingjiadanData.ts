import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '请假人',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'sex'
   },
   {
    title: '年龄',
    align:"center",
    dataIndex: 'age'
   },
   {
    title: '请假事由',
    align:"center",
    dataIndex: 'remark'
   },
   {
    title: '开始时间',
    align:"center",
    dataIndex: 'beginDate'
   },
   {
    title: '结束时间',
    align:"center",
    dataIndex: 'endDate'
   },
   {
    title: '请假天数',
    align:"center",
    dataIndex: 'days'
   },
];