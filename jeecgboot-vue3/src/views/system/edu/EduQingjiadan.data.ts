import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
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
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "请假人",
      field: 'name',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "性别",
      field: 'sex',
      component: 'Input',
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '请假人',
    field: 'name',
    component: 'Input',
  },
  {
    label: '性别',
    field: 'sex',
    component: 'Input',
  },
  {
    label: '年龄',
    field: 'age',
    component: 'Input',
  },
  {
    label: '请假事由',
    field: 'remark',
    component: 'Input',
  },
  {
    label: '开始时间',
    field: 'beginDate',
    component: 'Input',
  },
  {
    label: '结束时间',
    field: 'endDate',
    component: 'Input',
  },
  {
    label: '请假天数',
    field: 'days',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  name: {title: '请假人',order: 0,view: 'text', type: 'string',},
  sex: {title: '性别',order: 1,view: 'text', type: 'string',},
  age: {title: '年龄',order: 2,view: 'text', type: 'string',},
  remark: {title: '请假事由',order: 3,view: 'text', type: 'string',},
  beginDate: {title: '开始时间',order: 4,view: 'text', type: 'string',},
  endDate: {title: '结束时间',order: 5,view: 'text', type: 'string',},
  days: {title: '请假天数',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}