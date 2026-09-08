<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div>
        <BasicForm @register="registerForm">
            <!-- 选择校区 -->
            <template #tc="{ model, field }">
                <a-radio-group v-model:value="model[field]">
                    <a-tooltip placement="top">
                        <template #title>
                            <span>地址:沈阳市洋南区金科街</span>
                        </template>
                        <a-radio value="a">A</a-radio>
                    </a-tooltip>
                    <a-tooltip placement="top">
                        <template #title>
                            <span>地址:沈阳市沈北新区张经济开发区</span>
                        </template>
                        <a-radio value="b">B</a-radio>
                    </a-tooltip>
                </a-radio-group>
            </template>
            <!-- 选择时段 -->
            <template #ti="{ model, field }">
                <a-range-picker v-model:value="model[field]" valueFormat="YYYY-MM-DD"></a-range-picker>
            </template>
        </BasicForm>
        <a-button @click="handleSubmit">提交</a-button>
    </div>
</template>

<script setup lang="ts">
// 引入表单组件
import { useForm, BasicForm, FormSchema } from '@/components/Form'
// 配置表单控件
const formSchemas: FormSchema[] = [
    {
        label: '姓名',
        field: 'name',
        component: 'Input'
    },
    {
        label: '性别',
        field: 'sex',
        component: 'JDictSelectTag',
        componentProps: {
            type: 'radio',
            dictCode: 'sex'
        }
    },
    {
        label: '兴趣课',
        field: 'course',
        required: true,
        component: 'Select',
        dynamicPropskey: 'options',
        dynamicPropsVal: ({ model }) => {
            if (model.sex == 1) {
                return [
                    { value: '0', label: '篮球' },
                    { value: '1', label: '足球' }
                ]
            } else if (model.sex == 2) {
                return [
                    { value: '2', label: '羽毛球' },
                    { value: '3', label: '乒乓球' }
                ]
            } else { return [] }
        }
    },
    {
        label: '联系方式',
        field: 'contactType',
        component: 'JDictSelectTag',
        defaultValue: 1,
        componentProps: {
            type: 'radio',
            options: [
                { value: '0', label: 'QQ' },
                { value: '1', label: '微信' },
            ]
        }
    },
    {
        label: 'QQ号',
        field: 'qqNumber',
        required: true,
        component: 'Input',
        ifShow: ({ model }) => {
            if (model.contactType == 0) {
                setProps({ labelWidth: 100 })
            }
            return model.contactType == 0;
        }
    },
    {
        label: '微信号',
        field: 'wxNumber',
        required: true,
        component: 'Input',
        ifShow: ({ model }) => {
            if (model.contactType == 1) {
                setProps({ labelWidth: 100 })
            }
            return model.contactType == 1;
        }
    },
    {
        label: '教学中心',
        field: 'trainingCenter',
        required: true,
        component: 'Input',
        slot: 'tc'
    },
    {
        label: '选择时段',
        field: 'time',
        required: true,
        component: 'Input',
        componentProps: {
            valueType: 'Array'
        },
        slot: 'ti'
    }
]
const [registerForm, { setProps, validate }] = useForm({
    schemas: formSchemas,
    showResetButton: false,
    showSubmitButton: false,
    labelWidth: 90,
});

const handleSubmit = async () => {
    const values = await validate();
    console.log("values:", values);
}
</script>

<style lang="less" scoped></style>