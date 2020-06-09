<template>
  <div>
    <el-table
            :data="tableData"
            border
            style="width: 100%">
      <el-table-column
              fixed
              prop="id"
              label="编号"
              width="150">
      </el-table-column>
      <el-table-column
              prop="name"
              label="书名"
              width="120">
      </el-table-column>
      <el-table-column
              prop="author"
              label="作者"
              width="120">
      </el-table-column>
      <el-table-column
              fixed="right"
              label="操作"
              width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
            background
            layout="prev, pager, next"
            page-size="1"
            :total="total"
            @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
  export default {
    methods: {
      deleteBook(row){
        let _this = this
        axios.delete("http://localhost:8181/book/deleteById/"+row.id)
        .then(function (resp) {
          _this.$alert('删除成功', '删除', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload()
            }
          })
        })
      },
      edit(row){
        this.$router.push({
          path: "/update",
          query:{
            id:row.id
          }
        })
      },
      handleClick(row) {
        console.log(row);
      },
      page(currentPage){
        // alert(currentPage)
        let that = this
        axios.get("http://localhost:8181/book/findAll/"+currentPage+"/3")
                .then(function (resp) {
                  that.tableData = resp.data
                  console.log(resp)
                })
      }
    },

    data() {
      return {
        total: null,
        tableData: []
      }
    },
    created() {
      let that = this
      axios.get("http://localhost:8181/book/findAll/1/3")
      .then(function (resp) {
        that.tableData = resp.data
        console.log(resp)
      })
      axios.get("http://localhost:8181/book/getPage/3")
      .then(function (resp) {
        console.log(resp);
        that.total = resp.data
      })
    }
  }
</script>