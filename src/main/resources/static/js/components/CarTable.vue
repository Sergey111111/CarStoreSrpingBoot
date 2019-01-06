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
      v-for="adv in this.advs"
      @click="$emit('showCar')"
    >
      <th scope="row">{{adv.id}}</th>
      <td>{{adv.user.name}}</td>
      <td>{{adv.text}}</td>
      <td>{{adv.car.name}}</td>
      <td>{{adv.creationDate}}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props:['advs']
}
</script>

<style>

</style>
