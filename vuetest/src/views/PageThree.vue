<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="编号">
      <el-input v-model="ruleForm.id" readonly></el-input>
    </el-form-item>
    <el-form-item label="书名" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="作者" prop="author">
      <el-input v-model="ruleForm.author"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
      <el-button @click="test()">test</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          name: '',
          author: '',
        },
        rules: {
          name: [
            { required: true, message: '图书名称不能为空', trigger: 'blur' },
          ],
          author: [
            { required: true, message: '作者名称不能为空', trigger: 'blur' },
          ],

        }
      };
    },
    methods: {
      test() {
        console.log(this.ruleForm)
      },
      submitForm(formName) {
        const _this = this
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.put("http://localhost:8181/book/update",_this.ruleForm)
                    .then(function (resp) {
                      if (resp.data == 'success'){
                        // alert("添加成功")
                        _this.$alert('修改成功', '修改', {
                          confirmButtonText: '确定',
                          callback: action => {
                            _this.$router.push("/BookManage")
                          }
                        })


                      }
                    })
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    created() {
      const _this = this
      axios.get("http://localhost:8181/book/findById/"+this.$route.query.id)
      .then(function (resp) {
        _this.ruleForm = resp.data
      })
    }
  }
</script>


<style scoped>

</style>