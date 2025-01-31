const obj = {
  name: "Ani",

  getName() {
    // using this in arrow functions refers to window object in browser and global object in nodejs
    // console.log(this.name);

    const arrowFunc = () => {
      console.log(this.name);
    };

    arrowFunc();
  },
};

obj.getName.bind(obj);

console.log(obj.getName());
