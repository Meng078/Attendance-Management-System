<!-- eslint-disable vue/multi-word-component-names -->
<template>
    <div>
        hello world
    </div>
</template>
<!--<script src=http://localhost:3101/src/views/super/airag/aiapp/chat/js/chat.js id="e7e007dd52f67fe36365eff636bbffbd"></script>
 <script>
    createAiChat({
       appId:"2097851753539944449",
       shareToken:"5cce0ddcf8784104b2e7455424b8c7bb",
       // 支持top-left左上, top-right右上, bottom-left左下, bottom-right右下
       iconPosition:"bottom-right"
    })
 </script>-->
<script setup lang="ts">
import { ref, onMounted } from 'vue'

onMounted(() => {
    const script = document.createElement('script')
    script.src = 'http://localhost:3101/src/views/super/airag/aiapp/chat/js/chat.js'
    script.id = 'e7e007dd52f67fe36365eff636bbffbd'
    script.onload = () => {
        createAiChat({
            appId: "2097851753539944449",
            shareToken: "5cce0ddcf8784104b2e7455424b8c7bb",
            // 支持top-left左上, top-right右上, bottom-left左下, bottom-right右下
            iconPosition: "bottom-right"
        })
    }
    document.body.appendChild(script)
})

</script>

<style lang="less" scoped></style>