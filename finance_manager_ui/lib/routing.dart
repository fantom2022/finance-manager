import 'package:finance_manager_ui/pages/home.dart';
import 'package:flutter/material.dart';

class Routing {
  static Map<String, Function> routePageMap = {
    '/': (BuildContext context) => const HomePage(),
  };
}
