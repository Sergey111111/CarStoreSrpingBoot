<template>
  <table class="table table-hover">
    <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">User</th>
      <th scope="col">Text</th>
      <th scope="col">Car</th>
      <th scope="col">Created</th>
    </tr>
    </thead>
    <tbody>
    <tr
      v-for="car in this.cars"
      @click="$emit('showCar',car.id)"
    >
      <th scope="row">{{car.id}}</th>
      <td>{{car.user.name}}</td>
      <td>{{car.text}}</td>
      <td>{{car.name}}</td>
      <td>{{car.creationDate}}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props:['cars']
}
</script>

<style>

</style>
