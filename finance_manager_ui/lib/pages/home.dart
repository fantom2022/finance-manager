import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var iterator = 0;
    return Scaffold(
      appBar: AppBar(
        title: const Text("Финансы"),
        centerTitle: true,
      ),
      body: const Center(
        child: Text("Тут"),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          iterator++;
          print("Количество кликов: $iterator");
        },
      ),
    );
  }
}
