<template>
  <div class="container-fluid">
    <p>Google authorization required </p>
    <ul class="nav flex-column">
      <li class="nav-item ">
        <a class="nav-link" href="/login"
           @click="$emit('authorize')">
          Log-in
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: "Unlogged"
  }
</script>

<style scoped>
  .nav-item {
    border: #31a1ff 2px solid;
    border-radius: 5px;
  }
</style>
