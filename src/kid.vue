<template>
    <div class="wapper">
        <text @click="onclick" class="button">
            点击我啊
        </text>

        <text @click="onpush" class="button">
            点击跳转
        </text>
    </div>
</template>
<script>
    const model = weex.requireModule('modal')
    var navigator = weex.requireModule('navigator')
    var api = weex.requireModule('./api');

    export  default{
        methods: {
            onclick(event){
                model.toast({
                    message: "onclick",
                    duration: 0.8
                });
            },
            onpush(event){
                navigator.push({
                    url: 'my.js',
                    animated: "true"
                }, event => {
                    modal.toast({ message: 'callback: ' + event })
                })
            }
        }
    }
</script>

<style>
    .button {
        background-color: red;
        border-radius: 5;
    }
</style>