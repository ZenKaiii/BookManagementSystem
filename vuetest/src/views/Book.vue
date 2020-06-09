<template>
  <div>
    <table>
      <tr>
        <td>编号</td>
        <td>图书名称</td>
        <td>作者</td>
      </tr>
      <tr v-for="book in books">
        <td>{{book.id}}</td>
        <td>{{book.name}}</td>
        <td>{{book.author}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
    export default {
        name: "Book",
        data(){
            return {
                msg:'hello vue',
                books: [],
            }
        },
        created() {
            const _this = this
            axios.get("http://localhost:8181/book/findAll")
            .then(function (resp) {
                console.log(resp)
                _this.books = resp.data
            })
        }
    }
</script>

<style scoped>

</style>