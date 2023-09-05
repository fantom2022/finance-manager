import 'package:finance_manager_ui/pages/home.dart';
import 'package:finance_manager_ui/routing.dart';
import 'package:flutter/material.dart';

class FinanceManagerApp extends StatelessWidget {
  const FinanceManagerApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Финансы',
      initialRoute: '/',
      routes: Routing.routePageMap,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
    );
  }
}
